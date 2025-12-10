import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Isotope {
    String name;
    double atomicMass;
    double naturalAbundance;
    int atomicNumber;
    String chemicalSymbol;
    int neutrons;
    int protons;
    int electrons;
    String electronConfiguration;

    public Isotope(String name, double atomicMass, double naturalAbundance, int atomicNumber,
                    String chemicalSymbol, int neutrons, int protons, int electrons,
                    String electronConfiguration) {
        this.name = name;
        this.atomicMass = atomicMass;
        this.naturalAbundance = naturalAbundance;
        this.atomicNumber = atomicNumber;
        this.chemicalSymbol = chemicalSymbol;
        this.neutrons = neutrons;
        this.protons = protons;
        this.electrons = electrons;
        this.electronConfiguration = electronConfiguration;
    }

    public String getName() {
        return name;
    }

    public String getChemicalSymbol() {
        return chemicalSymbol;
    }

    public double getAtomicMass() {
        return atomicMass;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public int getNeutrons() {
        return neutrons;
    }

    public int getProtons() {
        return protons;
    }

    public int getElectrons() {
        return electrons;
    }

    public String getElectronConfiguration() {
        return electronConfiguration;
    }

    public double getNaturalAbundance() {
        return naturalAbundance;
    }

    @Override
    public String toString() {
        return "Isotope{" +
                "name='" + name + '\'' +
                ", atomicMass=" + atomicMass +
                ", naturalAbundance=" + naturalAbundance +
                ", atomicNumber=" + atomicNumber +
                ", chemicalSymbol='" + chemicalSymbol + '\'' +
                ", neutrons=" + neutrons +
                ", protons=" + protons +
                ", electrons=" + electrons +
                ", electronConfiguration='" + electronConfiguration + '\'' +
                '}';
    }
}
