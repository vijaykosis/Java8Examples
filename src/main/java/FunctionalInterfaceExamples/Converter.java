package FunctionalInterfaceExamples;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

