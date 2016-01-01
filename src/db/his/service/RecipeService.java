package db.his.service;

import db.his.dao.RecipeDao;
import db.his.domain.Drug;
import db.his.domain.Recipe;
import db.his.domain.Recipe_Treatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lwt on 2015/12/30.
 * 处方、
 */
@Service
public class RecipeService {
    @Autowired
    private RecipeDao recipeDao;

    /**
     *
     * @return drugs
     * @throws SQLException
     */
    public List<Drug> queryDrug() throws SQLException {

        return recipeDao.queryAll();
    }

    /**
     * 插入处方
     * @param r
     * @param rts
     * @throws SQLException
     */
    public void insert(Recipe r, List<Recipe_Treatment> rts) throws SQLException {
        recipeDao.insert(r,rts);
    }
}
