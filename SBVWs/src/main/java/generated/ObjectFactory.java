//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.02.05 at 08:07:40 AM ICT 
//


package generated;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Envelope }
     * 
     */
    public Envelope createEnvelope() {
        return new Envelope();
    }

    /**
     * Create an instance of {@link Envelope.Body }
     * 
     */
    public Envelope.Body createEnvelopeBody() {
        return new Envelope.Body();
    }

    /**
     * Create an instance of {@link Envelope.Body.Content }
     * 
     */
    public Envelope.Body.Content createEnvelopeBodyContent() {
        return new Envelope.Body.Content();
    }

    /**
     * Create an instance of {@link Envelope.Header }
     * 
     */
    public Envelope.Header createEnvelopeHeader() {
        return new Envelope.Header();
    }

    /**
     * Create an instance of {@link Envelope.Body.Content.Result }
     * 
     */
    public Envelope.Body.Content.Result createEnvelopeBodyContentResult() {
        return new Envelope.Body.Content.Result();
    }

    /**
     * Create an instance of {@link Envelope.Header.Reference }
     * 
     */
    public Envelope.Header.Reference createEnvelopeHeaderReference() {
        return new Envelope.Header.Reference();
    }

    /**
     * Create an instance of {@link Envelope.Header.From }
     * 
     */
    public Envelope.Header.From createEnvelopeHeaderFrom() {
        return new Envelope.Header.From();
    }

    /**
     * Create an instance of {@link Envelope.Header.To }
     * 
     */
    public Envelope.Header.To createEnvelopeHeaderTo() {
        return new Envelope.Header.To();
    }

    /**
     * Create an instance of {@link Envelope.Header.Subject }
     * 
     */
    public Envelope.Header.Subject createEnvelopeHeaderSubject() {
        return new Envelope.Header.Subject();
    }

}
