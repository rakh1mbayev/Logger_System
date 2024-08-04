Logger System (Task 2)

Description
The Logger system processes a stream of messages, each tagged with a timestamp, and follows these rules:

* Unique Message Lifetime: Each unique message remains in the system for a maximum of 10 seconds. A message received at timestamp t will block identical messages from being printed until the timestamp reaches t + 10 seconds.
* Chronological Processing: Messages are processed in the order they arrive.
* Simultaneous Messages: Multiple messages can arrive at the same timestamp.
* System Clearing: The system can be cleared at a specific timestamp, provided no messages are being processed at that time.
* Capacity Limit: The system has a capacity limit of 100 entries. If this limit is exceeded, the system will be cleared before adding a new unique message.


Running the Program
To start the program, run filename.java. The program accepts several commands:

1. $finish: Terminates the program.
2. $size: Returns the current size of the Logger.
3. $clean: Clears the Logger.
Commands are case-insensitive ($FiNiSH, $SIZE, $clEAN are all accepted).


Input Format:
The first line receives the message.
The second line receives the timestamp.

Output:
If the message can be printed at the given timestamp, the status will be: True. Otherwise, the status will be: False.
