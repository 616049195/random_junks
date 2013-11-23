require 'time'
require 'active_support'
# check last_login

# set monthy_active = true if..

# else set monthy_active true.

# else do nothing.

time = Time.now.getutc
time2 = Time.now
time_int = Time.now.to_i

puts "The time is #{time.methods}"

puts "The time is #{time.localtime}"
puts "The time is #{time_int}"
puts "Time 2 is #{time2}"

puts "Time 2 .to_date: #{time.to_date}"
puts "Time 2 .to_time: #{time.to_time}"
puts "Time 2 .localtime #{time.localtime}"

# puts "Time int to time: #{time_int.to_time}"

puts "The month: #{time.mon}"
puts "The day: #{time.mday}"
puts "The hour: #{time.hour}"
puts "The minute: #{time.min}"

puts "#{time - time2}"


timenow = Time.now
puts "Meet me at #{timenow.tomorrow}"

# 1.day.ago