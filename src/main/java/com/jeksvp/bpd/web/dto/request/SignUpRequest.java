package com.jeksvp.bpd.web.dto.request;

import com.jeksvp.bpd.domain.entity.Role;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @Size(min = 1, max = 20)
    private String username;

    @Size(min = 6, max = 30)
    private String password;

    @NotBlank
    private String email;

    @NotNull
    private Role role;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    private String aboutMe;

    @AssertTrue(message = "Required fields for psychotherapist is empty.")
    public boolean isValidPsychotherapistFields() {
        if (Role.PSYCHOTHERAPIST.equals(this.role)) {
            return validateAsPsychotherapist();
        }
        return true;
    }

    private boolean validateAsPsychotherapist() {
        return StringUtils.isNotBlank(this.firstName)
                && StringUtils.isNotBlank(this.lastName);
    }
}
