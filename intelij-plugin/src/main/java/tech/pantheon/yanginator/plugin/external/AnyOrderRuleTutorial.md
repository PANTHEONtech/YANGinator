## This External rule is used because of this comment in RFC 6020

`;; these stmts can appear in any order`

### How the rule works:

We are using generated code from parser as a base and adding `anyOrder` logic to the code. The methods return value is
pretty simple: return true if we matched and parsed the given items and return false if not.

- How to add this External Rule to .bnf :
  `parserUtilClass="tech.pantheon.yanginator.plugin.external.ExternalRules"`

- How to implement:
  `externalRule ::= <<anyOrder first second third>>`

- Note that you can also use [] for optional and */+ for repeating items

*These static imports are used from generated parser.*

`if (!recursion_guard_(b, l, "whateverString")) return false;`

` PsiBuilder.Marker m = enter_section_(b);`

`exit_section_(b, m, null, whateverBoolean);`

The method parameter of this rule have to be of type `Parser or int or boolean` otherwise it will not work. For more in
depth explanation read https://github.com/JetBrains/Grammar-Kit .

### The parser functional Interface has one simple method and that is `parse`, which will return:

- true if the item was matched and parsed
- true if the item was optional, so it was matched but not parsed
- false if it was not matched or parsed

Because of this we had to use PsiBuilder method `getCurrentOffset()`. This method returns *int*
value of current offset.

#### This way, we can say if the matched word was optional or not.

- If it was matched (returned true) and the offset did not change that means it was optional.
- If it was matched (returned true) and the offset changed, that means the item was matched and parsed

Now we can store the optional values and try parsing them later (otherwise they would return true and be considered
parsed). Try looking through the generated parser code and comparing optional and non-optional methods.

### The Cycles

- First cycle is used to move to the next element. By increasing the level `l+=1` we move to the next element.
- Second cycle is used to try matching the elements to the ones from first cycle. This way we can guarantee that every
  single element has been tried to be matched with each other.
- Third cycle is for optional items. If the parse method returned true but the offset did not move, that means that the
  item was optional. We store optional items and try parsing them later(so that no item is skipped).

### *Note that this rule does not check for duplicates!*

for examle:

- in this rule `externalRule ::= <<anyOrder 'A' ('B')* 'C'>>`

a sequence `"A A B C"` would be considered successfully parsed, even though it should not. Because of this, duplicates
are later checked in annotator.