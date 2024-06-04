package instructions;

public class LoadConstant extends Instruction {
	int r;
	int c;
	
	LoadConstant(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
