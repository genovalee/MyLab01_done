package model.view;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Oct 23 16:58:48 GMT+08:00 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DepartmentsViewRowImpl extends ViewRowImpl {
    public static final int ENTITY_DEPARTMENTS = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        DepartmentId,
        DepartmentName,
        ManagerId,
        LocationId,
        EmployeesView;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int DEPARTMENTID = AttributesEnum.DepartmentId.index();
    public static final int DEPARTMENTNAME = AttributesEnum.DepartmentName.index();
    public static final int MANAGERID = AttributesEnum.ManagerId.index();
    public static final int LOCATIONID = AttributesEnum.LocationId.index();
    public static final int EMPLOYEESVIEW = AttributesEnum.EmployeesView.index();

    /**
     * This is the default constructor (do not remove).
     */
    public DepartmentsViewRowImpl() {
    }
}

