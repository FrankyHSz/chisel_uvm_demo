
import chisel3._
import chisel3.util.Enum
import chisel3.util.{switch, is, SwitchContext}

class ALU extends Module {

  val add :: sub :: and :: or :: Nil = Enum(4)

  val io = IO(new Bundle() {
    val opcode = Input(UInt(2.W))
    val opA = Input(UInt(8.W))
    val opB = Input(UInt(8.W))
    val res = Output(UInt(8.W))
    val carry = Output(Bool())
  })

  val intRes = WireDefault(0.U(9.W))

  switch (io.opcode) {
    is (add) { intRes := io.opA + io.opB }
    is (sub) { intRes := io.opA - io.opB }
    is (and) { intRes := io.opA & io.opB }
    is (or)  { intRes := io.opA | io.opB }
  }

  io.res   := intRes(7, 0)
  io.carry := intRes(8)
}
