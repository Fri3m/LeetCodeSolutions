/* Solved in MS SQL Server*/
select allDays.dt 'Day', cast(( ISNULL(canT.total * 1.0, 0) / (ISNULL(comT.comTotal * 1.0 , 0) + ISNULL(canT.total * 1.0, 0))) as decimal(10,2)) 'Cancellation Rate'
from (
         select request_at 'dt'
         from Trips t
         where t.client_id not in (
             select c.users_id
             from Users c
             where banned = 'Yes'
         ) and t.driver_id not in (
             select d.users_id
             from Users d
             where banned = 'Yes'
         )
         group by t.request_at
         having t.request_at in ('2013-10-01','2013-10-02', '2013-10-03')
     ) allDays left join
     (
         select tx.request_at 'dt', Count(*) 'comTotal'
         from Trips tx
         where tx.status = 'completed' and tx.client_id not in (
             select c.users_id
             from Users c
             where banned = 'Yes'
         ) and tx.driver_id not in (
             select d.users_id
             from Users d
             where banned = 'Yes'
         )
         group by tx.request_at
     ) comT on comT.dt = allDays.dt left join (
    select ts.request_at 'dt', Count(*) 'total'
    from Trips ts
    where ts.status in ('cancelled_by_driver','cancelled_by_client') and ts.client_id not in (
        select c.users_id
        from Users c
        where banned = 'Yes'
    ) and ts.driver_id not in (
        select d.users_id
        from Users d
        where banned = 'Yes'
    )
    group by ts.request_at
) canT on allDays.dt = canT.dt