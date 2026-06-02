package week_12_part2;

public class UserAuthentication {

    public static void main(String[] args) {

    	// Username and Password Authentication
        Authentication auth1 = new UsernamePasswordAuth();
        AuthenticationProcessor processor1 = new AuthenticationProcessor(auth1);

        System.out.println("Username/Password Login:");
        processor1.login();

        System.out.println();

        // Social Login Authentication 
        Authentication auth2 = new SocialLoginAuth();
        AuthenticationProcessor processor2 = new AuthenticationProcessor(auth2);

        System.out.println("Social Login:");
        processor2.login();

        System.out.println();

        // Two-Factor Authentication 
        Authentication auth3 = new TwoFactorAuthSystem();
        AuthenticationProcessor processor3 = new AuthenticationProcessor(auth3);

        System.out.println("Two-Factor Authentication:");
        processor3.login();
    
    }
}

// Handles authentication flow without knowing implementation details
class AuthenticationProcessor {
    private Authentication auth;

    AuthenticationProcessor(Authentication auth) {
        this.auth = auth;
    }

    void login() {
        auth.authenticate();
    }
}

// Base contract for all authentication types
interface Authentication {
    void authenticate();
}

// Capability for password-based authentication
interface PasswordAuth {
    void enterPassword();
}

// Capability for OTP verification
interface TwoFactorAuth {
    void verifyOTP();
}

// Username + password authentication
class UsernamePasswordAuth implements Authentication, PasswordAuth {

    public void enterPassword() {
        System.out.println("Enter password");
    }

    public void authenticate() {
        enterPassword();
        System.out.println("Log in using username and password");
    }
}

// Social login authentication (Google, Facebook, etc.)
class SocialLoginAuth implements Authentication {

    public void authenticate() {
        System.out.println("Log in using social account");
    }
}

// Two-factor authentication system
class TwoFactorAuthSystem implements Authentication, PasswordAuth, TwoFactorAuth {

    public void enterPassword() {
        System.out.println("Enter password");
    }

    public void verifyOTP() {
        System.out.println("Enter OTP code");
    }

    public void authenticate() {
        enterPassword();
        verifyOTP();
        System.out.println("Log in using two-factor authentication");
    }
}