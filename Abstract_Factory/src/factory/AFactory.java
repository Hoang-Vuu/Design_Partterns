package factory;

import product.Button;
import product.Checkbox;
import product.TextField;

import product.a.ButtonA;
import product.a.TextFieldA;
import product.a.CheckboxA;

public class AFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }
}