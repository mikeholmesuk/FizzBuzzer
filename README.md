# FizzBuzzer
A modified interpretation of the fizz-buzz problem done as part of a technical test. 

### Notes

Rather than using the bog-standard 'white board' approach of using a simple `if`/`else` structure, this solution goes a bit further and utlises the `Chain of responsibility` pattern to allow the various classifiers to be passed in to the `calculator`.

One benefit of this is that each `classifier` can be tested individually. Also it can be seen from the transition from the initial commit to the second phase - adding a new `classifier` (lucky in that case) can be added in a fairly trivial manner (apart from the requisite tests). 

### Running

The project has been setup using `gradle` so can be run using the following:

`gradle run`

The tests can be run by using the following:

`gradle test`

### The benefit of Hindsight

Thinking about this after actually doing it (a benefit not always afforded to us) it is clear that there are a lot of classes which, while useful initially, would probably become very unwieldy very quickly if you had a few more rules to apply to the numbers (amongst various other problems that naturally occur when doing something in a relatively short amount of time). 

To this end the following are noted as potential (future or never)improvements:

* Abstract the individual `classifier`s to a single `class` that takes, for example, a `Predicate` and a string to return. This would mean that the `classifier`s were less explicitly named but would cut down the number of classes considerably. 
* Wrap the various formatters and chain them together (similar to how the `classifier`s work) so that additional formatting options could be added more easily.
* etc etc (there are always improvements).... 
  

### Output (all phases)

The output from the first task is as follows:

```$xslt
Welcome to Fizz-Buzz
--------------------

1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz fizz 22 23 fizz buzz 26 fizz 28 29 fizzbuzz 31 32 fizz 34 buzz fizz 37 38 fizz buzz 41 fizz 43 44 fizzbuzz 46 47 fizz 49 buzz fizz 52 53 fizz buzz 56 fizz 58 59 fizzbuzz 61 62 fizz 64 buzz fizz 67 68 fizz buzz 71 fizz 73 74 fizzbuzz 76 77 fizz 79 buzz fizz 82 83 fizz buzz 86 fizz 88 89 fizzbuzz 91 92 fizz 94 buzz fizz 97 98 fizz buzz

```

Output from the second phase is as follows:

```
Welcome to Fizz-Buzz
--------------------
   
1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz fizz 22 lucky fizz buzz 26 fizz 28 29 lucky lucky lucky lucky lucky lucky lucky lucky lucky lucky buzz 41 fizz lucky 44 fizzbuzz 46 47 fizz 49 buzz fizz 52 lucky fizz buzz 56 fizz 58 59 fizzbuzz 61 62 lucky 64 buzz fizz 67 68 fizz buzz 71 fizz lucky 74 fizzbuzz 76 77 fizz 79 buzz fizz 82 lucky fizz buzz 86 fizz 88 89 fizzbuzz 91 92 lucky 94 buzz fizz 97 98 fizz buzz
```


Output from the final phase is as follows:

```$xslt
Welcome to Fizz-Buzz
--------------------

1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz fizz 22 lucky fizz buzz 26 fizz 28 29 lucky lucky lucky lucky lucky lucky lucky lucky lucky lucky buzz 41 fizz lucky 44 fizzbuzz 46 47 fizz 49 buzz fizz 52 lucky fizz buzz 56 fizz 58 59 fizzbuzz 61 62 lucky 64 buzz fizz 67 68 fizz buzz 71 fizz lucky 74 fizzbuzz 76 77 fizz 79 buzz fizz 82 lucky fizz buzz 86 fizz 88 89 fizzbuzz 91 92 lucky 94 buzz fizz 97 98 fizz buzz
fizz: 21 buzz: 13 fizzbuzz: 5 lucky: 19 integer: 42
```

### Libraries Used

'junit', name: 'junit', version: '4.12' ],
'uk.org.fyodor', name: 'fyodor-core', version: '1.0.0' ],
'org.assertj', name: 'assertj-core', version: '3.8.0' ],
'org.mockito', name: 'mockito-core', version: '2.+' ]

The ony external libraries used to build this are used for testing. This is to enable useful things such as mocked dependencies and random test data (which I'm a big fan of). The libraries used are as follows:

* [Junit](https://github.com/junit-team/junit4) - standard
* [Fyodor](https://github.com/fyodor-org-uk/fyodor) - An excellent library for generating random data.
* [AssertJ](https://github.com/joel-costigliola/assertj-core) - Lurvely assertions
* [Mockito](https://github.com/mockito/mockito) - An excellent library for creating and testing mocks.