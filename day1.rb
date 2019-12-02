require 'csv'
lines = CSV.read('input/day1.txt', 'r').to_a

def rock_it_mass(m)
  sum = 0
  loop do
    m = (m / 3).floor - 2
    break if m <= 0
    sum += m 
  end
  sum
end

masses = lines.map do |line|
  int = line[0].to_i
  rock_it_mass(int)
end
puts masses.reduce(&:+)
