import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Vector implements Iterable<Double> {
    private double[] coordinates;

    public Vector(int dimension) {
        this.coordinates = new double[dimension];
    }

    public Vector(Vector vector) {
        this.coordinates = Arrays.copyOf(vector.coordinates, vector.coordinates.length);
    }

    public Vector(double[] coordinates) {
        this.coordinates = Arrays.copyOf(coordinates, coordinates.length);
    }

    public int getSize() {
        return coordinates.length;
    }

    public double getCoordinate(int index) {
        return coordinates[index];
    }

    public void setCoordinate(int index, double value) {
        coordinates[index] = value;
    }

    public double calculateLength() {
        double sum = 0;
        for (double coordinate : coordinates) {
            sum += coordinate * coordinate;
        }
        return Math.sqrt(sum);
    }

    @Override
    public String toString() {
        StringBuilder strbild = new StringBuilder("(");
        for (int i = 0; i < coordinates.length; i++) {
            strbild.append(coordinates[i]);
            if (i < coordinates.length - 1) {
                strbild.append(", ");
            }
        }
        strbild.append(")");
        return strbild.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector vector = (Vector) obj;
        return Arrays.equals(coordinates, vector.coordinates);
    }


   public Iterator<Double> iterator() {
        return new CoordinateIterator();
    }

    //Внутрішній клас
    public class CoordinateIterator implements Iterator<Double>
    {
        private int index = 0;


        @Override
        public boolean hasNext() {
            return index < coordinates.length;
        }

        @Override
        public Double next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }

            return coordinates[index++];
        }
    }
    //Анонімний внутрішній клас
   /* public Iterator<Double> iterator() {
        return new Iterator<Double>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < coordinates.length;
            }

            @Override
            public Double next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return coordinates[index++];
            }
        };
    }*/


    //Локальний внутрішній клас
     /*public Iterator<Double> iterator()
    {
        class LocalCoordinateIterator implements Iterator<Double>
        {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < coordinates.length;
            }

            @Override
            public Double next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return coordinates[index++];
            }
        }

        return new LocalCoordinateIterator();
    }*/
}


/* В цьому випадку краще використовувати Внутрішній клас, код має більш чітку стрктуру
також це дозволяє отримувати доступ доя приватних полів зовнішнього класу
та також можна використовувати в іншах чатинах програми*/

/* Також можна вивористовувати Локальний внутрішній клас ,
 але при використанні його ми можемо використовувати ітератор лише в межах методу де він визначений*/
