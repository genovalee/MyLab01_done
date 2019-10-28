package view;

import model.am.AppModuleImpl;

import model.view.DepartmentsViewImpl;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.jbo.ViewCriteria;

import view.utils.ADFUtils;

public class Backing {
    private RichSelectOneChoice DepartmentId;

    public void setDepartmentId(RichSelectOneChoice DepartmentId) {
        this.DepartmentId = DepartmentId;
    }

    public RichSelectOneChoice getDepartmentId() {
        return DepartmentId;
    }

    public Backing() {
    }
    
    public Integer getByDepartmentId_action(){
        Integer DepartmentId = (Integer)getDepartmentId().getValue();
        System.out.println("DepartmentId:"+DepartmentId);
        getDepartmentsByDepartmentId(DepartmentId);
        return null;
    }
    
    public void getDepartmentsByDepartmentId(Integer DepartmentId) {
        System.out.println("getDepartmentsByDepartmentId");
        AppModuleImpl am = (AppModuleImpl) ADFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
        DepartmentsViewImpl DepartmentsView = am.getDepartmentsView1();
        ViewCriteria vc = DepartmentsView.getViewCriteria("DepartmentsViewCriteria");
        DepartmentsView.removeApplyViewCriteriaName(vc.getName());
        DepartmentsView.setNamedWhereClauseParam("pDepartmentId", DepartmentId);
        DepartmentsView.setApplyViewCriteriaName("DepartmentsViewCriteria");
        DepartmentsView.executeQuery();
    }

    public void clearDepartmentsVCs(DepartmentsViewImpl DepartmentsView){
        String[] vcs = DepartmentsView.getAllViewCriteriaNames();
        for(String s:vcs){
            System.out.println(s);
            DepartmentsView.removeApplyViewCriteriaName(s);
        }
        DepartmentsView.executeQuery();
    }
    public String refreshData_action() {
        AppModuleImpl am = (AppModuleImpl) ADFUtils.getApplicationModuleForDataControl("AppModuleDataControl");
        DepartmentsViewImpl DepartmentsView = am.getDepartmentsView1();
        clearDepartmentsVCs(DepartmentsView);
        return null;
    }
}
