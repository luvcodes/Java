# 概念

[![](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707822629188-5db2a094-c714-4280-92b2-63b842484102.png)](https://cdn.nlark.com/yuque/0/2024/png/38953059/1707822629188-5db2a094-c714-4280-92b2-63b842484102.png)

模板方法设计模式是一种行为设计模式，它定义了一个操作中的算法的骨架，并将一些步骤延迟到子类中实现。这样，算法的结构可以保持不变，同时通过子类提供的部分实现，可以改变算法的某些特定步骤。模板方法模式是通过定义一个抽象类来实现的，其中提供了一个模板方法，这个模板方法由一系列抽象操作或具体操作的调用组成，具体操作由抽象类实现，而抽象操作则由具体子类实现。

## 工作原理

1. **抽象基类**：定义了一系列的基本操作（方法），其中包括抽象操作和具体操作。还定义了一个模板方法，这个方法由一系列基本操作组成，其中包括算法的不变部分（具体操作）和变化部分（抽象操作）。抽象操作必须由子类实现。
2. **具体子类**：实现基类中定义的抽象方法，以提供算法中的特定步骤的实现。每一个子类都可以提供一个不同的实现，从而使得算法的某些部分可以变化。

## 使用场景

模板方法模式适用于以下场景：

- 当我们有多个类有着相同的方法，但是这些方法的执行步骤略有不同时，可以使用模板方法模式。这样，可以将这些公共部分的代码移动到一个单一的位置，减少代码的重复。
- 当需要控制子类扩展的点时，可以使用模板方法模式。模板方法可以定义一个算法的框架，允许子类在不改变算法结构的情况下，重写算法的特定步骤。

## 优点

- 促进代码复用。
- 可以利用模板方法来控制某些算法的框架和执行步骤。
- 将算法的框架和实际的执行步骤分离，易于扩展和维护。

## 缺点

- 因为继承的使用，可能会导致一系列的子类产生，这会增加系统的复杂性。
- 有时可能会引入钩子方法（可选的回调方法），增加了理解的难度。

## 示例

假设我们有一个游戏开发框架，我们希望定义一个游戏的基本流程（如初始化、开始、游戏循环、结束等），但是每个游戏的具体实现细节不同。我们可以定义一个抽象类`Game`，其中包含游戏流程的模板方法和一些抽象方法（如`initialize`、`startPlay`、`endPlay`）。然后，具体的游戏类继承自`Game`，实现这些抽象方法来提供具体的游戏逻辑。

通过这种方式，模板方法模式使得游戏开发框架可以定义游戏的基本框架，同时允许开发者通过继承和实现具体方法来创建具有不同游戏逻辑的游戏。

# 代码实现

```Java
public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();
    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
```

```Java
public class CharDisplay extends AbstractDisplay{
    // 需要显示的字符
    private char ch;

    // 构造函数中接收的字符被保存在字段中
    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
```

```Java
public class StringDisplay extends AbstractDisplay{
    // 需要显示的字符串
    private String string;

    // 以字节为单位计算出的字符串长度
    private int width;

    // 构造函数中接收的字符串被保存在字段中
    public StringDisplay(String string) {
        this.string = string;
        // 将字符串的字节长度也保存在字段中
        this.width = string.getBytes().length;
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
```

这段代码展示了模板方法设计模式的一个经典应用。其中包含一个抽象基类`AbstractDisplay`和两个具体实现类`CharDisplay`与`StringDisplay`。这个例子演示了如何在不同的场景下以相同的框架（即模板方法）展示不同的数据（字符或字符串）。

## 抽象基类：`AbstractDisplay`

- `AbstractDisplay`类定义了三个抽象方法：`open()`, `print()`, `close()`，这些方法在子类中被具体实现，以提供不同的行为。
- 它还定义了一个`final`方法`display()`，这是一个模板方法，它规定了展示内容的步骤和框架。首先调用`open()`方法打开或准备展示，接着循环调用`print()`方法五次来重复展示内容，最后调用`close()`方法结束展示。这个方法被标记为`final`，意味着子类不能重写它，确保了算法的步骤不会被更改。

## 具体实现类：`CharDisplay`

- `CharDisplay`是`AbstractDisplay`的一个具体实现，用于展示单个字符。
- 它重写了`open()`, `print()`, `close()`方法来实现具体的展示逻辑：`open()`方法打印出“<<”，`print()`方法打印出一个指定的字符`ch`，`close()`方法打印出“>>”。

## 具体实现类：`StringDisplay`

- `StringDisplay`也是`AbstractDisplay`的一个具体实现，用于展示一个字符串。
- 与`CharDisplay`不同，`StringDisplay`在`open()`和`close()`方法中调用私有方法`printLine()`来打印出一个由`+`和组成的边框，而`print()`方法则打印出被`|`符号包围的字符串。
- `StringDisplay`还计算并存储了字符串的长度（`width`），这用于`printLine()`方法中边框的长度。

## 使用场景

这个代码示例演示了如何使用模板方法设计模式来定义一个操作的框架（这里是展示一些内容），同时允许子类通过实现抽象方法来提供具体的行为。这样做的好处是算法的结构被保持（在`display()`方法中定义），而算法的某些步骤可以根据不同的需求来变化（通过`open()`, `print()`, `close()`方法的不同实现）。这提供了代码的复用性和扩展性。