package bean;

import entity.Computer;

/**
 *		��Ʒ��Ŀ�ศ��cart���ʵ��
 */
public class CartItem {
		private Computer c;
		private int qty;
		public Computer getC() {
			return c;
		}
		public void setC(Computer c) {
			this.c = c;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}
		@Override
		public String toString() {
			return "CartItem [c=" + c + ", qty=" + qty + "]";
		}
		
}
