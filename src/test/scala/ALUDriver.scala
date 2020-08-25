
import chisel3._
import chisel3.iotesters.PeekPokeTester

class ALUDriver(dut: ALU) extends PeekPokeTester(dut) {

  class inputType(op: UInt, a: Int, b: Int) {
    val opcode = op
    val opA = a.U(8.W)
    val opB = b.U(8.W)
  }

  val inputs = Array(
    new inputType(dut.add, 1, 2),
    new inputType(dut.sub, 5, 3),
    new inputType(dut.and, 4, 2),
    new inputType(dut.or,  4, 2)
  )

  var idx = -1

  def next(): Unit = {
    idx += 1
    if (idx < 4) {
      poke(dut.io.opcode, inputs(idx).opcode)
      poke(dut.io.opA, inputs(idx).opA)
      poke(dut.io.opB, inputs(idx).opB)
    }
  }
}
