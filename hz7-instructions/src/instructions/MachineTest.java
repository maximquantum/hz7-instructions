package instructions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
