package bean;

import java.util.ArrayList;
import java.util.List;


public class Cart {
		List<CartItem> items = new ArrayList<CartItem>();
		/*
		 * 向购物车中添加商品,如果已经购买则返回false
		 */
		public boolean add(CartItem item){
			for(int i=0;i<items.size();i++){
				if(items.get(i).getComputer().getId()==item.getComputer().getId()){
					return false;
				}
			}
			items.add(item);
			return true;
		}
		/*
		 * 列出购物车中的所有商品
		 */
		public List<CartItem> list(){
			return items;
		}
		/*
		 * 计算购物车中所有商品的总价
		 * 
		 */
		public double sumPrice(){
			double sum = 0;
			for(int i=0;i<items.size();i++){
				CartItem curr = items.get(i);
				sum+= curr.getComputer().getPrice() * curr.getQty();
			}
			return sum;
		}
		/*
		 * 修改商品的数量
		 */
		public void modify(long id, int qty){
			for(int i=0;i<items.size();i++){
				CartItem curr = items.get(i);
				if(curr.getComputer().getId()==id){
					curr.setQty(qty);
					return;
				}
			}
		}
		//删除购物车中的某一个商品
		public void delete(long id){
			for(int i=0;i<items.size();i++){
				CartItem curr = items.get(i);
				if(curr.getComputer().getId()==id){
					items.remove(curr);
					return;//循环结束，提高系统的性能
				}
			}
		}
		
		//清空购物车
		public void clear(){
			items.clear();
		}
		
		/*
		 * 将购物车中的商品的ID和数量转换成字符串添加到Cookie中
		 * 例如(1,2;8,5)第一个是购买的商品的id，第二个是购买的数量
		 * 如果没有商品则返回0
		 */
		public String store(){
			StringBuffer buff = new StringBuffer();
			if(items.size()==0){
				buff.append("0");
			}else{
				for(int i=0;i<items.size();i++){
					CartItem curr = items.get(i);
					buff.append(curr.getComputer().getId()+","+curr.getQty()+";");
				}
			}
			if(buff.length()>1){
				buff.deleteCharAt(buff.length()-1);
			}
			return buff.toString();
		}
		/*
		 * 恢复购物车，加载cookie中的商品的信息，并尝试恢复
		 */
		public void load(String content){
			if(content==null||content.equals("0")){
				return;//没有必要恢复
			}
			String[] strs = content.split(";");
			
		}
}
