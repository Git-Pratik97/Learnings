package designPatterns.creational;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        GUIFactory guiFactory;
        String osType = "Windows";

        if(osType.equals("Windows")){
            guiFactory = new WindowsGuiFactory();
        }else{
            guiFactory = new MacOsGuiFactory();
        }

        Application application = new Application(guiFactory);
        application.renderUI();
    }
}

interface Button{
    public void render();
}

class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows Button...");
    }
}

class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering MacOS Button...");
    }
}

interface CheckBox{
    public void render();
}

class WindowsCheckBox implements CheckBox{
    @Override
    public void render() {
        System.out.println("Rendering Windows Checkbox...");
    }
}

class MacOSCheckBox implements CheckBox {
    @Override
    public void render() {
        System.out.println("Rendering MacOS Checkbox...");
    }
}

interface GUIFactory{
    Button createButton();
    CheckBox createCheckBox();
}

class WindowsGuiFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}

class MacOsGuiFactory implements GUIFactory{
    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }

    @Override
    public Button createButton() {
        return new MacOSButton();
    }
}

class Application {
    Button button;
    CheckBox checkBox;

    public Application(GUIFactory guiFactory){
        this.button = guiFactory.createButton();
        this.checkBox = guiFactory.createCheckBox();
    }

    public void renderUI(){
        button.render();;
        checkBox.render();
    }
}
