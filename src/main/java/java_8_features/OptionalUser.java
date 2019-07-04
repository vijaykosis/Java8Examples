package java_8_features;

import java.util.Optional;

public class OptionalUser {

    OptionalAddress optionalAddress;

    public Optional<OptionalAddress> getOptionalAddress() {
        return Optional.of(optionalAddress);
    }

    public void setOptionalAddress(OptionalAddress optionalAddress) {
        this.optionalAddress = optionalAddress;
    }
}
