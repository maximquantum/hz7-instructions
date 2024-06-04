package instructions;

public class JumpIfZero extends Instruction {
	int r;
	int a;
	
	JumpIfZero(int r, int a) {
		this.r = r;
		this.a = a;
	}
}
