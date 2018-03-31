package bean;

import java.util.ArrayList;
import java.util.List;

import dao.ComputerDAO;
import dao.impl.ComputerDAOJdbcImpl;
import entity.Computer;

/**
 * 	���ﳵ�࣬Ϊ�˷����session���а󶩲�������Ƶ�һ���ࡣ
 * 	�ṩ�������Ʒ��ɾ����Ʒ���Ƽۣ��޸���Ʒ�������Ʒ����Ʒ�б� ��
 * �汾��������2������store()��load()
 */
public class Cart {
	//�����û��������Ʒ
	private List<CartItem> items = new ArrayList<CartItem>();
	public boolean add(CartItem item){
		
		//�����Ʒ֮ǰ���ȿ��Ƿ��Ѿ����������Ʒ
		for(int i=0;i<items.size();i++){
			CartItem curr = items.get(i);
			if(curr.getC().getId()==item.getC().getId()){
				//�Ѿ������������false���������
				return false;
			}
		}
		items.add(item);
		return true;
	}
	/**
	 * ���ع��ﳵ��ȫ������Ʒ��Ϣ
	 */
		public List<CartItem> list(){
			return items;
		}
		/**
		 * �Ƽ�
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
		 * ɾ����Ʒ
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
		 * �޸���Ʒ����
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
		 *	��cart�е�������Ʒ��Ϣ����items�����е�����ת���һ��
		 *	����"3,8;4,11;9,2"�������ַ�����
		 *	�����ϢΪ�գ����ء�0����
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
			    //�Ƴ�������ָ��λ�õ� char�������н�����һ�� char��
				//sb.length()-1������������һ���ַ�����ɾ�����һ���ַ�";"
				sb.deleteCharAt(sb.length()-1);
			}
			return sb.toString();
		}
		/**
		 * ����content(����"3,8;4,11;9,2"�������ַ���)
		 * ���»ָ�cart���û����������Ʒ����items���ϡ�
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
					item.setC(c);//��Computer������ӵ�CartItem��
					item.setQty(qty);
					items.add(item);//item���뼯��
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
}
