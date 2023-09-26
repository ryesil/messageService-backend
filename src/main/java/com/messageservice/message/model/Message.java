package com.messageservice.message.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="messages")
public class Message implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotBlank(message = "Not blank needed")
   @NotEmpty(message = "Not empty needed")
   @NotNull(message = "Please provide a valid subject for your email")
   @Size(max=50, message = "Your subject {validatedValue} can be at most {max} characters long")
   @Column( length = 200, nullable = false)
   private String subject;

   @NotBlank(message = "Not blank needed")
   @NotEmpty(message = "Not empty needed")
   @NotNull(message = "Please provide message body")
   @Size(max=1000, message = "Your body {validatedValue} must be between {min} and {max} characters long")
   @Column( length = 1000, nullable = false)
   private String body;

   @NotBlank(message = "Not blank needed")
   @NotEmpty(message = "Not empty needed")
   @NotNull(message = "Please provide your email")
   @Size(min=5,max=50, message = "Your email must be between 5 and 50 characters long")
   @Column( length = 200, nullable = false)
   @Email(message = "Please enter a valid email")
   private String email;

   @NotBlank(message = "Not blank needed")
   @NotEmpty(message = "Not empty needed")
   @NotNull(message = "Please provide your name")
   @Size(min=5,max=14, message = "Your phone {validatedValue} must be between {min} and {max} characters long")
   @Column( length = 14, nullable = false)
   @Pattern(regexp = "^(?:\\+1)?[ -]?\\(?([2-9][0-8][0-9])\\)?[ -]?([2-9][0-9]{2})[ -]?([0-9]{4})$")
   private String phoneNumber;


   @Temporal(TemporalType.TIMESTAMP)
   private Date timestamp;

}
