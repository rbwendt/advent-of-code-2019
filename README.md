# advent-of-code-2019
I probably won't finish this 🎄

### day 1

#### part 1
`cat input/day1.txt | while read p; do echo "scale=0;  ($p/3)-2" | bc  ; done | paste -sd+ - | bc`

#### part 2
`ruby day1.rb`
