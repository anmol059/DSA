package stacks;

public class stackUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stackUsingArrays st = new stackUsingArrays();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		st.push(60);
		st.push(70);
		st.push(80);
		st.push(90);
		st.push(100);
		st.push(110);

		int size = st.size();
		
		for (int i = 0; i < size; i++) {
			st.display();
			try {
				int waste = st.pop();
				
			} catch (stackEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
