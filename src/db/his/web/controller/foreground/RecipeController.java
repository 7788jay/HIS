package db.his.web.controller.foreground;

import db.his.domain.Doctor;
import db.his.domain.Drug;
import db.his.domain.Recipe;
import db.his.domain.Recipe_Treatment;
import db.his.service.RecipeService;
import db.his.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lwt on 2015/12/30.
 * 处方
 */
@Controller
@RequestMapping("/fore/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    /**
     * 查询药品
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/queryDrug")
    public List<Drug> queryDrug(){
        try {
            return recipeService.queryDrug();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 插入处方及药品
     * @param r
     * @param rts
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/insert")
    public ModelMap insert(Recipe r, @RequestBody Recipe_Treatment[] rts, HttpSession session){
        try {
            Doctor doctor = (Doctor) session.getAttribute("user");
            r.setDoctor_id(doctor.getDoctor_id());
            String recipe_id = WebUtils.makeId();
            r.setRecipe_id(recipe_id);
            recipeService.insert(r, Arrays.asList(rts));
        } catch (SQLException e) {
            e.printStackTrace();
            return new ModelMap("message", "保存失败！");
        }
        return new ModelMap("message", "保存成功！");
    }
}
