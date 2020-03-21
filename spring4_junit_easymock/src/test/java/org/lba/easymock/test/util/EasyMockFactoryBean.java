package org.lba.easymock.test.util;

import org.easymock.EasyMock;
import org.springframework.beans.factory.FactoryBean;

public class EasyMockFactoryBean<T> implements FactoryBean<T> {

    /**
     * Enumeration to define the type of mock.
     */
    public enum MockType {

        /**
         * Mock created by {@link EasyMock#createMock(Class)}
         */
        DEFAULT,

        /**
         * Mock created by {@link EasyMock#createNiceMock(Class)}
         */
        NICE,

        /**
         * Mock created by {@link EasyMock#createStrictMock(Class)}
         */
        STRICT
    }

    private Class<T> classToBeMocked;
    private MockType mockType = MockType.DEFAULT;

    /**
     * Creates an EasyMock mock instance of the provided class of type {@link MockType#DEFAULT}.
     * @param classToBeMocked The class to be mocked.
     */
    public EasyMockFactoryBean(Class<T> classToBeMocked) {
        this(classToBeMocked, MockType.DEFAULT);
    }

    /**
     * Creates a mock instance of the provided class of type {@link MockType#DEFAULT}.
     * @param classToBeMocked The class to be mocked.
     * @param mockType The {@link MockType} to be created.
     */
    public EasyMockFactoryBean(Class<T> classToBeMocked, MockType mockType) {
        this.classToBeMocked = classToBeMocked;
        this.mockType = mockType;
    }

    @Override
    public T getObject() throws Exception {
        switch (mockType) {
            case DEFAULT:
                return EasyMock.createMock(classToBeMocked);
            case NICE:
                return EasyMock.createNiceMock(classToBeMocked);
            case STRICT:
                return EasyMock.createStrictMock(classToBeMocked);
            default:
                throw new IllegalStateException("Unknown MockType: " + mockType);
        }
    }

    @Override
    public Class<T> getObjectType() {
        return classToBeMocked;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
