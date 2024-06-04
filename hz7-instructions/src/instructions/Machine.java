package instructions;

public class Machine {
	static void execute(int[] registers, Instruction[] instructions) {
		int pc = 0;
		for (;;) {
			Instruction i = instructions[pc]
;
			if (i instanceof LoadConstant lc) {
				registers[lc.r] = lc.c;
				pc++;
			} else if (i instanceof JumpIfZero j ) {
				if (registers[j.r] == 0)
					pc = j.a;
				else
					pc++;
			} else if (i instanceof Jump j) {
				pc = j.a;
			} else if (i instanceof Halt) {
				break;
			} else if (i instanceof Multiply m) {
				registers[m.r1] *= registers[m.r2];
				pc++;
			} else if (i instanceof Decrement d) {
				registers[d.r]--;
				pc++;
			}
		}
	}
}