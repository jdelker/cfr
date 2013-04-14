package org.benf.cfr.reader.bytecode.analysis.types;

/**
 * Created with IntelliJ IDEA.
 * User: lee
 * Date: 02/04/2013
 * Time: 17:19
 */
public interface InnerClassInfo {
    boolean isInnerClass();

    boolean isInnerClassOf(JavaTypeInstance possibleParent);

    void setHideSyntheticThis();

    boolean isHideSyntheticThis();

    /*
     * I'd rather not have this in the interface, but at the point when we're creating the class, we only
     * know its name, not if it has a 'legit outer'.
     */
    void markAnonymous();

    boolean isAnoynmousInnerClass();

    JavaRefTypeInstance getOuterClass();

    public static InnerClassInfo NOT = new InnerClassInfo() {
        @Override
        public boolean isInnerClass() {
            return false;
        }

        @Override
        public boolean isAnoynmousInnerClass() {
            return false;
        }

        @Override
        public void markAnonymous() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isInnerClassOf(JavaTypeInstance possibleParent) {
            return false;
        }

        @Override
        public void setHideSyntheticThis() {
            throw new IllegalStateException();
        }

        @Override
        public JavaRefTypeInstance getOuterClass() {
            throw new IllegalStateException();
        }

        @Override
        public boolean isHideSyntheticThis() {
            return false;
        }
    };
}