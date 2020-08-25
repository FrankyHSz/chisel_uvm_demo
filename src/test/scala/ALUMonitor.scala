
import chisel3.iotesters.PeekPokeTester

class ALUMonitor(dut: ALU) extends PeekPokeTester(dut) {

  // Valid opcodes
  val add = dut.add.toInt
  val sub = dut.sub.toInt
  val and = dut.and.toInt
  val or  = dut.or.toInt

  def next(): Boolean = {
    val currOpCode = peek(dut.io.opcode).toInt
    val currOpA    = peek(dut.io.opA).toInt
    val currOpB    = peek(dut.io.opB).toInt

    val expOutput = currOpCode match {
      case this.add => currOpA + currOpB
      case this.sub => currOpA - currOpB
      case this.and => currOpA & currOpB
      case this.or  => currOpA | currOpB
      case _ => -1
    }

    expect(dut.io.res, expOutput)
  }
}
