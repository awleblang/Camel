package camel.syntaxhighlighter;

import javax.swing.text.*;

public class OCamlViewFactory {

  /**
     * @see javax.swing.text.ViewFactory#create(javax.swing.text.Element)
     */
    public View create(Element element) {
 
        return new OCamlView(element);
    }

}