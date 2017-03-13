package bean;

import java.util.ArrayList;
import java.util.List;

import dao.ComputerDAO;
import dao.impl.ComputerDAOJdbcImpl;
import entity.Computer;

/**
 * 	购物车类，为了方便对session进行绑订操作而设计的一个类。
 * 	提供了添加商品，删除商品，计价，修改商品，清空商品，商品列表 。
 * 版本二：增加2个方法store()和load()
 */
public class Cart {
	//保存用户购买的商品
	private List<CartItem> items = new ArrayList<CartItem>();
	public boolean add(CartItem item){
		
		//添加商品之前，先看是否已经购买过该商品
		for(int i=0;i<items.size();i++){
			CartItem curr = items.get(i);
			if(curr.getC().getId()==item.getC().getId()){
				//已经购买过，返回false，不再添加
				return false;
			}
		}
		items.add(item);
		return true;
	}
	/**
	 * 返回购物车中全部的商品信息
	 */
		public List<CartItem> list(){
			return items;
		}
		/**
		 * 计价
		 */
		public double sum(){
			double sum=0;
			for(int i=0;i<items.size();i++){
				CartItem curr = items.get(i);
				sum += curr.getQty()*curr.getC().getPrice();
			}
			return sum;
		}
		/**
		 * 删除商品
		 */
		public void delete(long id){
			for(int i=0;i<items.size();i++){
				CartItem curr = items.get(i);
				if(curr.getC().getId()==id){
					items.remove(curr);
					return ;
				}
			}
		}
		/**
		 * 修改商品数量
		 */
		public void modify(long id,int qty){
			for(int i=0;i<items.size();i++){
				CartItem curr = items.get(i);
				if(curr.getC().getId()==id){
					curr.setQty(qty);
					return ;
				}
			}
		}
		public void clear(){
			items.clear();
		}
		/**
		 *	将cart中的所有商品信息，即items集合中的数据转变成一个
		 *	类似"3,8;4,11;9,2"这样的字符串。
		 *	如果信息为空，返回“0”。
		 * @return
		 */
		public String store(){
			StringBuffer sb = new StringBuffer();
			if(items.size()==0){
				sb.append("0");
			}else{
				for(int i=0;i<items.size();i++){
					CartItem item = items.get(i);
					sb.append(item.getC().getId()+","
						+item.getQty()+";");
				}
			}
			if(sb.length()>1){
				//public StringBuffer deleteCharAt(int index)
			    //移除此序列指定位置的 char。此序列将缩短一个 char。
				//sb.length()-1这个序列是最后一个字符，即删除最后一个字符";"
				sb.deleteCharAt(sb.length()-1);
			}
			return sb.toString();
		}
		/**
		 * 依据content(类似"3,8;4,11;9,2"这样的字符串)
		 * 重新恢复cart中用户所购买的商品，即items集合。
		 * @param content
		 */
		public void load(String content){
			if(content==null||content.equals("0")){
				return;
			}
			String[] pcs = content.split(";");
			for(int i=0;i<pcs.length;i++){
				String pc = pcs[i];
				String[] strs = pc.split(",");
				long id=Long.parseLong(strs[0]);
				int qty = Integer.parseInt(strs[1]);
				ComputerDAO dao = new ComputerDAOJdbcImpl();
				try{
					Computer c = dao.findById(id);
					CartItem item = new CartItem();
					item.setC(c);//把Computer对象添加到CartItem中
					item.setQty(qty);
					items.add(item);//item放入集合
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
}
