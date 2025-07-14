package com.workintech.developers;

public class HRManager extends Employee {
    private JuniorDeveloper[] juniorDevelopers;
    private MidDeveloper[] midDevelopers;
    private SeniorDeveloper[] seniorDevelopers;

    public HRManager(int id, String name, double salary) {
        super(id, name, salary);
        this.juniorDevelopers = new JuniorDeveloper[5]; // Başlangıç boyutu
        this.midDevelopers = new MidDeveloper[5];
        this.seniorDevelopers = new SeniorDeveloper[5];
    }

    @Override
    public void work() {
        System.out.println("HR Manager starts managing employees");
        setSalary(getSalary() * 1.15); // %15 zam
    }

    public void addEmployee(JuniorDeveloper developer) {
        addEmployee(developer, juniorDevelopers);
    }

    public void addEmployee(MidDeveloper developer) {
        addEmployee(developer, midDevelopers);
    }

    public void addEmployee(SeniorDeveloper developer) {
        addEmployee(developer, seniorDevelopers);
    }

    private <T extends Employee> void addEmployee(T developer, T[] developers) {
        for (int i = 0; i < developers.length; i++) {
            if (developers[i] == null) {
                developers[i] = developer;
                System.out.println(developer.getClass().getSimpleName() + " added at index " + i);
                return;
            }
        }
        
        // Eğer doluysa, dizi boyutunu genişlet
        T[] newArray = (T[]) java.lang.reflect.Array.newInstance(
            developers.getClass().getComponentType(), 
            developers.length * 2);
        System.arraycopy(developers, 0, newArray, 0, developers.length);
        newArray[developers.length] = developer;
        
        if (developer instanceof JuniorDeveloper) {
            juniorDevelopers = (JuniorDeveloper[]) newArray;
        } else if (developer instanceof MidDeveloper) {
            midDevelopers = (MidDeveloper[]) newArray;
        } else if (developer instanceof SeniorDeveloper) {
            seniorDevelopers = (SeniorDeveloper[]) newArray;
        }
        
        System.out.println("Array expanded and " + developer.getClass().getSimpleName() + 
                         " added at index " + developers.length);
    }
}