package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Car> getAll() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car", Car.class);
        return query.getResultList();
    }

    @Override
    public List<Car> getCountCar(int count) {
        TypedQuery<Car> query = sessionFactory.getCurrentSession()
                .createQuery("from Car i order by i.id", Car.class)
                .setMaxResults(count);
        return query.getResultList();
    }

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

}
