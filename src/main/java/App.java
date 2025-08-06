/**
 * Simple Java Application demonstrating DevOps Introduction
 * This showcases basic DevOps concepts and practices
 */
public class App {
    
    // Main method to run the application
    public static void main(String[] args) {
        System.out.println("=== Welcome to DevOps Introduction ===");
        
        App devopsApp = new App();
        devopsApp.displayDevOpsIntro();
        devopsApp.showDevOpsPrinciples();
        devopsApp.displayBenefits();
    }
    
    /**
     * Display basic introduction to DevOps
     */
    public void displayDevOpsIntro() {
        System.out.println("\n--- What is DevOps? ---");
        System.out.println("DevOps is a set of practices that combines software development (Dev)");
        System.out.println("and IT operations (Ops) to shorten the development lifecycle.");
        System.out.println("It emphasizes collaboration, automation, and continuous improvement.");
    }
    
    /**
     * Show key DevOps principles
     */
    public void showDevOpsPrinciples() {
        System.out.println("\n--- Key DevOps Principles ---");
        String[] principles = {
            "1. Continuous Integration (CI)",
            "2. Continuous Delivery (CD)", 
            "3. Infrastructure as Code (IaC)",
            "4. Monitoring and Logging",
            "5. Collaboration and Communication"
        };
        
        for (String principle : principles) {
            System.out.println(principle);
        }
    }
    
    /**
     * Display benefits of DevOps
     */
    public void displayBenefits() {
        System.out.println("\n--- DevOps Benefits ---");
        System.out.println("✓ Faster deployment and delivery");
        System.out.println("✓ Improved collaboration between teams");
        System.out.println("✓ Higher quality software");
        System.out.println("✓ Better reliability and stability");
        System.out.println("✓ Reduced time to market");
        
        System.out.println("\n--- End of DevOps Introduction ---");
        System.out.println("Thank you for learning about DevOps!");
    }
}
