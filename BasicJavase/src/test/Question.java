package test;
/**选择题*/
public class Question {
	
		int id ;//题号
		String text;//题干
		String[] options={};//选项

		public boolean check(String[] answers){
		return false;
	}
	public void print(){
		System.out.println(id+"."+text);
		for(int i=0;i<options.length;i++){
			System.out.println(""+options[i]);
		}
		System.out.println();
	}
}
