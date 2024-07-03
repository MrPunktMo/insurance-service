create view all_tab_columns as
select tab.table_schema as database_schema,
    tab.table_name as table_name,
    col.ordinal_position as column_id,
    col.column_name as column_name,
    col.data_type as data_type
from information_schema.tables as tab
    inner join information_schema.columns as col
        on col.table_schema = tab.table_schema
        and col.table_name = tab.table_name
where tab.table_type = 'BASE TABLE'
    and tab.table_schema not in ('information_schema','mysql',
        'performance_schema','sys')
    -- uncomment line below for current database onlyregion
    -- and tab.table_schema = database() 
    -- uncomment line below and provide specific database name
    -- and tab.table_schema = 'your_database_name' 
order by tab.table_name,
    col.ordinal_position;