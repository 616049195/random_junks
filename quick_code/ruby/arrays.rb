## main ##

arr = ['don\'t', 'down', 'bring', 'me']
print arr, "\n"
puts 'Guess: ', arr
puts arr
print arr, "\n"


puts arr[0], " ", arr[2], " ", arr[3], " ", arr[1]
print arr[0], " ", arr[2], " ", arr[3], " ", arr[1], "\n"
puts

=begin
HASHES
=end
puts "HASHES..."

_hash = {
	'1234' => "DAVID",
	"1235" => "DANIEL",
	'1236' => 'DECAF',
	'1237' => 'BABY'
}

puts _hash
puts _hash['1235']
puts _hash[1234]
puts _hash['1234']
puts _hash['123123123']


_hash2 = Hash.new(-1)
# this line will generate entirely a new hash object
_hash2 = {'123' => 'babo'}

puts _hash2
puts _hash2['12345']
puts _hash2['12345'] == nil

_hash3 = Hash.new(-1)
_hash3['123'] = 'newthing'

puts _hash3['123']
puts _hash3['123412341234']

puts "\nHIHIHIHIHIHIIHIHIH\n"

_hash4 = Hash.new("don't have it")
_hash4[123] = '123'
puts _hash4
puts _hash4[123]
puts _hash4['123']


