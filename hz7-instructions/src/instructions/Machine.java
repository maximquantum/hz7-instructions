package instructions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

abstract class Instruction {}

class LoadConstant extends Instruction {
	int r;
	int c;
	
	LoadConstant(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class JumpIfZero extends Instruction {
	int r;
	int a;
	
	JumpIfZero(int r, int a) {
		this.r = r;
		this.a = a;
	}
}

class Jump extends Instruction {
	int a;
	
	Jump(int a) {
		this.a = a;
	}
}

class Halt extends Instruction{}

class Multiply extends Instruction {
	int r1;
	int r2;
	
	Multiply(int r1, int r2) {
		this.r1 = r1;
		this.r2 = r2;
	}
}

class Decrement extends Instruction {
	int r;
	
	Decrement(int r) {
		this.r = r;
	}
}

class Machine {
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

class MachineTest {

	@Test
	void test() {
		assertEquals(9, power(3, 2));
		assertEquals(128, power(2, 7));
	}
	
	int power(int x, int y) {
		Instruction[] program = {
				new LoadConstant(2, 1),
				new JumpIfZero(1, 5),
				new Multiply(2, 0),
				new Decrement(1),
				new Jump(1),
				new Halt()
		};
		int[] registers = {x, y, 0};
		Machine.execute(registers, program);
		return registers[2];
		
	}

}
