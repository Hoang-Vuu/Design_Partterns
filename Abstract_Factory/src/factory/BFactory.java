package factory;

import product.Button;
import product.Checkbox;
import product.TextField;

import product.b.ButtonB;
import product.b.TextFieldB;
import product.b.CheckboxB;

public class BFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldB(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxB(text);
    }
}