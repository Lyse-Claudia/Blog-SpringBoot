package com.claudia.blog.domain.dto;

import com.claudia.blog.domain.entity.UserAccount;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


public record CreatePostRequestDto(
        @NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH)
        @Length(max= 255, message = ERROR_MESSAGE_TITLE_LENGTH)
        String title,

        @NotBlank(message = ERROR_MESSAGE_CONTENT_LENGTH)
        @Length(max = 255, message = ERROR_MESSAGE_CONTENT_LENGTH)
        String content

        /*@NotNull(message = ERROR_MESSAGE_AUTHOR)
        @ManyToOne
        @JoinColumn(name = "author_id")
        UserAccount author*/
) {
        private static final String ERROR_MESSAGE_TITLE_LENGTH =
                "Title must be between 1 and 255 characters";
        private static final String ERROR_MESSAGE_CONTENT_LENGTH =
                "Content must be more than 255 characters";
        private static final String ERROR_MESSAGE_AUTHOR =
                "A post must have an author";


}
