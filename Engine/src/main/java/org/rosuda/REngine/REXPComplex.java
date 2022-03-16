package org.rosuda.REngine;

/**
 * @author Administrator
 * @since 2022-03-16
 */
public class REXPComplex extends REXPVector {
    private Complex[] payload; //store as [real,imaginary,real,imaginary]

    public REXPComplex(double real, double im) {
        super();
        this.payload = new Complex[]{new Complex(real, im)};
    }
    public REXPComplex(Complex cplx) {
        super();
        this.payload = new Complex[]{cplx};
    }
    public REXPComplex(Complex[] load) {
        super();
        payload = load == null ? new Complex[0] : load;
    }
    public REXPComplex(Complex[] load, REXPList attr) {
        super(attr);
        payload=load == null ? new Complex[0] :load;
    }
    public int length() {
        return payload.length ;
    }

    @Override
    public Object asNativeJavaObject() throws REXPMismatchException {
        return payload;
    }

    @Override
    public boolean isNumeric() {
        return true;
    }

    @Override
    public String[] asStrings() throws REXPMismatchException {

        String[] s = new String[payload.length];
        int i = 0;
        while (i < payload.length) { s[i] = ""+payload[i]; i++; }
        return s;
    }

    @Override
    public boolean[] isNA() {
        boolean a[] = new boolean[payload.length];
        int i = 0;
        while (i < a.length) { a[i] = payload[i].isNA(); i++; }
        return a;
    }
    public String toDebugString() {
        StringBuffer sb = new StringBuffer(super.toDebugString()+"{");
        int i = 0;
        while (i < payload.length && i < maxDebugItems) {
            if (i>0) sb.append(",");
            sb.append(payload[i]);
            i++;
        }
        if (i < payload.length) sb.append(",..");
        return sb.toString()+"}";
    }
}
