
import chisel3.iotesters.PeekPokeTester

class ALUTester(dut: ALU) extends PeekPokeTester(dut) {

  val outputs = Array(3, 2, 0, 6)
  val driver  = new ALUDriver(dut)
  val monitor = new ALUMonitor(dut)

  for (_ <- 0 until 4) {
    driver.next()
    monitor.next()
    step(1)
  }
}
