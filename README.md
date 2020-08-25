# Chisel UVM Demo
This repository is a simple test/demo created to test my ideas. Since SystemVerilog and its Unified Verification Methodology is so widespread but Chisel3 has no similar framework I tought about emulating it.

The main UVM constructs, such as drivers and monitors, are implemented as PeekPokeTesters. Their functionality is not in their constructor but in a function called "next", making them callable.

Cycle-level concurrency is emulated by a for loop in the "toplevel" PeekPokeTester. This loop calls the driver to poke the inputs of DUT, then calls the monitor to read these inputs, calculate the expected output value and check the output of DUT, then steps one clock cycle, repetitively.

With this simple ALU and very minimalist pseudo-UVM components all tests pass.

As this demo was intended only as a basic proof-of-concept for PeekPokeTester nesting, the files probably won't be updated.
