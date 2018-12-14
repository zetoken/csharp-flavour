# A flavor of C# in java

This *project defines some classes that help me converting/rewriting some C# projects to java*.

It meets my needs but I don't know if it will meet yours ;-) .

## Helpers provided

### C# properties
I'm in love with C# properties allowing very easy setter and getter declaration and implementation.

`Property`, `ReadOnlyProperty`, `AutoProperty` and `AutoReadOnlyProperty` aim at providing similar and convenient usage to java.

**Example of declaration**
```java
class PropertiesSample {
    // C#: public int AutoProperty { get; set; }
    public final AutoProperty<Integer> autoProperty = new AutoProperty<>();

    // C#: public boolean Property { get => _privateValue; set => _privateValue = value }
    private boolean _privateValue;
    public final Property<Boolean> property = new Property<>(
        () -> _privateValue,
        (v) -> _privateValue = v
    );

    // C#: public boolean ReadOnlyProperty { get => _privateValue; }
    private boolean _otherPrivateValue;
    public final ReadOnlyProperty<Boolean> otherProperty = new ReadOnlyProperty<>(
        () -> _otherPrivateValue
    );
}
```
**Example of the usage somewhere else...**
```java
PropertiesSample sample = new PropertiesSample();
sample.autoProperty.set(5); // C#: sample.AutoProperty = 5;
int propertyValue = sample.autoProperty.get(); // C#: var propertyValue = sample.AutoProperty;
```

### C# events
C# events provide a convenient implementation of the common observable pattern.

`EventHandler`, `EventArgs` and `IEventHandlerDelegate` aim at providing a similar functionality.

**Example of declaration**
```java
class EventSample {
    public final EventHandler<EventArgs> finished = new EventHandler<>();

    public void doSomeWork() {
        // Do some useful work and tell the world that the job is done
        finished.invoke(this, EventArgs.getEmpty());
    }
}
```
**Example of the usage somewhere else...**
```java
EventSample sample = new EventSample();
sample.finished.add((s, e) -> system.out.println("Event fired by " + s + " with args " + e));
sample.doSomeWork();
```
### Stopwatch

**Example of declaration**
C# StopWatch is a tool I use mostly to get raw elapsed time between 2 calls. This project implements only this usage, not all of C# StopWatch capabilities.
```java
StopWatch stopWatch = new StopWatch();
stopWatch.start();
// ...
int elapsedTime = stopWatch.getElapsedMilliseconds();
stopWatch.reset();
// ...
stopWatch.stop();
```
