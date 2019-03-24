package iocexample2;

public class Chinese implements Person {

	private Language language;
	public Chinese(){}
	
	public Chinese(Language language){
		this.language=language;
	}
	
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println(language.kind());
	}

}
