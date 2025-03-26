
## File generating
To correctly generate files follow steps in
[rfc-parser/README.md](rfc-parser/docs/README.md) file

To successfully enable Highlighter follow steps in
[intelij-plugin/docs/README.md](intelij-plugin/docs/README.md) file

Generated files have different code style and are without copyright header


***
### Code Style setup

First we need to import correct code style to IDE

* In IntelliJ IDEA go to ***Settings/Editor/Code style***  
* Next to Scheme selection click on **Show Scheme Actions** 
choose **Import Scheme** and then **IntelliJ IDEA code style XML**  
* Select file **CodeStyle.xml** located in ***config*** folder  
![CodeStyleImport](docs/images/howto-dev/CodeStyleMenu.png)

* Then you can choose own name for style,
after import make sure this style is chosen in **Scheme** 
selection setting and save the changes.

* then apply imported style to generated files,
  * In project window select folders with generated files, or whole ***tech.pantheon.yanginator.plugin*** package
  * then from context menu select **Reformat Code** (*Ctrl+Alt+L*) 
  * then in options window select **Optimize imports** and **Cleanup code** and click **run**  
![img.png](docs/images/howto-dev/ReformatCode.png)

***

## Configuration

### CompatibilityCheck

To configure versions of various IntelliJ platforms for compatibility, check modify ... a section in ... [build.gradle](intelij-plugin/build.gradle).
Note: Do not remove recommended() as it always tests a latest stable version of IntelliJ Idea!

Running the compatibility check,
You can run compability check in the terminal using the following command:
```shell
  gradle verifyPlugin
```
<p style="color:red;">Warning</p>It will download at least 20G worth of data or more, depending on the size of installation files. 

### Problems with JFlex Generator

If you experience errors, when you run JFlex generator. For example, duplicate code 
or missing variables. We recommend to delete jflex-*.jar and idea-flex.skeleton from project
root folder. Then start the build from scratch. The Program will ask where to save
these jflex files, where you should select project root folder.


### Copyright

* In IntelliJ IDEA go to ***Settings/Editor/Copyright/Copyright Profiles***  
* At top of the page on left side click on import button 
![img.png](docs/images/howto-dev/ImportIcon.png), 
select **[config/YANGinator-Copyright.xml](config/YANGinator-Copyright.xml)** file located in ***config*** folder

* Make sure that the correct copyright profile is selected in ***File/Settings/Editor/Copyright*** setting tab  
![img.png](docs/images/howto-dev/Copyright.png)
* To apply copyright to generated files, select files or folders and from context menu choose **update Copyright**
  * **\_YangLexer.java**
  * **psi** folder
  * **YangParser.java** or **parser** folder
  * **highlighter** folder

If you create new files, also apply copyright on them

***
***

When solving a grammar issue, you can just edit ***YangGrammar.bnf*** file 
and generate files from it without using parser to try if your solution works.  
**But for final solution** you have to edit **uncompliantUtils** in **rfc-parser** or tokens in **Tokens.xml**,
so **rfc-parser** would generate ***YangGrammar.bnf*** with changes you need.

For grammar these **rfc** models are used:  
* [**YANG 1.0**](https://www.rfc-editor.org/rfc/rfc6020)
* [**YANG 1.1**](https://www.rfc-editor.org/rfc/rfc7950)

For error search or check [***THESE***](https://github.com/openconfig/public/tree/master/release/models) 
open-config YANG files can be used  

All changes in comparison to rfc model should be noted to file
**[ModelDeviations](rfc-parser/docs/ModelDeviations.md)** where you can also find solutions to problems

***

### ABNF
Since generating grammar does not function with .abnf files it is required for the RFC to be translated
to .bnf format. This is done in the RFCParser class. 
BNF and ABNF format basics can be found here:
 - ABNF grammar rules can be found here: https://datatracker.ietf.org/doc/html/rfc5234
 - BNF basics are described here https://www.geeksforgeeks.org/bnf-notation-in-compiler-design/

### REGEX
Since we are generating Lexer it is required for the regex to only use lexer supported regex.
It can be found here:
 - https://westes.github.io/flex/manual/Patterns.html

## Pins
Pins are used when parsing. They describe the number of elements required for the statement to be considered
as parsed. The best example for this are deviation statements : each one of them require a deviation keyword
at the start, then a separator and finally a corresponding keyword representing the statement(add delete ...).
The pin for these statements is 3 because it is required to know what kind of deviation is to be parsed and 
checked for errors. Otherwise, it would be stuck at the first defined deviation statement in the grammar.

## Annotator
Annotator checks if the yang uses the correct version of the grammar. It takes the elements and checks 
if the statement consists of elements defined in the version of yang grammar. Yang version is written at the top
of the module (in the header statements) or if it is not written, then it is automatically version 1.0.

If there are some missing element errors, then it probably has something to do with grammar and/or annotator.
Annotator checks what yang version is used, then performs basic checks for elements defined in both versions
and then performs checks based on the yang-version. These checks consist of maxOne, minOne and maxZero element checks.
Elements surrounded in [ ] have to be checked with maxOne check. Elements with + have to be checked by minOne check.
Elements that aren't defined in version 1.0, but were added in 1.1 have to be checked by maxZero check if the file
uses yang-version 1.0.

After creating a new check class, it needs to be added to a list of checks in YangAnnotator class.

## Referencing
Registering a referencable element:
* In order for the element to be referencable it needs to extend YangGeneratedReferenceType. 
* It needs to be registered in YangReferenceContributor.
* It needs to have its referenced counterpart returned from getClassType() in YangUtil.

When reference is called, it gets the prefix and identifier of the referencing element.
Based on the prefix it gets all file names associated with the element (opened file and its included submodules if 
the prefix is not defined or only the file defined with prefix). Then it uses findIdentifierLiterals() from YangUtil 
to find the referenced element or elements and returns them as an array of ResolveResults.


## Completion contributor
Completion is performed in completion package, inside YangCompletionContributor class.
* When the completion starts the first method called is beforeCompletion() in which all the prerequisites for the 
completion are defined.
* The context parent is figured out inside findContextParentOfCurrentNode(), which is a recursive method. 
It goes through all elements from the current element upwards the psiTree. The context parent can be a statement,
keyword or group of statements(linkage, meta, revision, body statements).
* After the beforeCompletion is done, the next method called is fillCompletionVariants().
* It fills the result set with possible completions based on the context parent. The values and getter of possible 
completions are defined in YangCompletionContributorDataUtil.

To add or change the completion results for an element it needs to be added in MAP_OF_SUBSTATEMENTS inside
YangCompletionContributorDataUtil.java or have its own way to return its completion results (e.g. afterKeywordCompletion())


## Injection
Injection of external languages is performed in injection package and it uses MultiHostInjector. 
* First step is to extend and implement YangLanguageInjectionHost on the element in YangGrammar (e.g. quotedString).
* Second step is to register this element in RegExpToYangInjector class (which could be renamed) inside elementsToInjectIn() 
and the context in which it should be injected in getLanguagesToInject().
* The last step, if the class was renamed, is to register this injection extension in plugin.xml.

[**Injections by IntelliJ**](https://plugins.jetbrains.com/docs/intellij/language-injection.html) 
