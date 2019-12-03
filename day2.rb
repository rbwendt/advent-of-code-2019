def computer(memory, command)
  opcodes = {
    1 => :+,
    2 => :*
  }

  operation, operand_a, operand_b, position = command
  if operation == 99
    def memory.done?
      true
    end
    return memory
  end
  
  if opcodes[operation].nil?
    puts "error bad op code #{operation}"
    exit
  end

  first = memory[operand_a].nil?? 0 : memory[operand_a]
  secon = memory[operand_b].nil?? 0 : memory[operand_b]
  memory[position] = first.send(opcodes[operation], secon)
  memory
end

def parse_input(inp)
  inp.split(',').map(&:to_i).each_slice(4)
end

# input = "1,9,10,3,2,3,11,0,99,30,40,50"
input = "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,10,19,1,6,19,23,2,23,6,27,2,6,27,31,2,13,31,35,1,10,35,39,2,39,13,43,1,43,13,47,1,6,47,51,1,10,51,55,2,55,6,59,1,5,59,63,2,9,63,67,1,6,67,71,2,9,71,75,1,6,75,79,2,79,13,83,1,83,10,87,1,13,87,91,1,91,10,95,2,9,95,99,1,5,99,103,2,10,103,107,1,107,2,111,1,111,5,0,99,2,14,0,0"
# input = "1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,10,19,1,6,19,23,2,23,6,27,2,6,27,31,2,13,31,35,1,10,35,39,2,39,13,43,1,43,13,47,1,6,47,51,1,10,51,55,2,55,6,59,1,5,59,63,2,9,63,67,1,6,67,71,2,9,71,75,1,6,75,79,2,79,13,83,1,83,10,87,1,13,87,91,1,91,10,95,2,9,95,99,1,5,99,103,2,10,103,107,1,107,2,111,1,111,5,0,99,2,14,0,0"
# input = "1,0,0,0,99"
# input = "2,3,0,3,99"
# input = "2,4,4,5,99,0"
# input = "1,1,1,4,99,5,6,0,99"

def run_all(input, replace1, replace2)
  memory = parse_input(input).to_a.flatten
  def memory.done?
    false
  end
  memory[1] = replace1
  memory[2] = replace2

  input = parse_input(input)
  input.each_with_index do |operation, i|
    operation = memory[4*i..4*i+4]
    # puts memory.inspect, operation.inspect
    memory = computer(memory, operation)
    break if memory.done?
  end
  return memory[0]
end

puts run_all(input,12,2)

target = 19690720

cs = 0.upto(100).to_a
cs.product(cs).each do |a, b|
  if (x = run_all(input, a, b)) == target
    puts 100 * a + b
    break
  end
end
