import { Check, Edit, Trash2, X } from 'lucide-react';
import Link from 'next/link';
import { useState } from 'react';

type TableRootProps<T, K extends keyof T> = {
  key: K;
  data: T[];
  columns: {
    heading: string;
    element: (row: T) => JSX.Element;
  }[];
};

export function TableRoot<T, K extends keyof T>({
  data,
  columns
}: TableRootProps<T, K>) {
  return (
    <table className='w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400'>
      <thead className='text-xs text-gray-700 uppercase bg-gray-100 dark:bg-gray-700 dark:text-gray-400'>
        <tr>
          {columns.map(({ heading }, index) => (
            <th key={`column-${index}`} scope='col' className='px-6 py-3'>
              {heading}
            </th>
          ))}
        </tr>
      </thead>

      <tbody>
        {data.map((row, rowIndex) => (
          <>
            {console.log(row)}
            <tr
              key={rowIndex}
              className='bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600'
            >
              {columns.map((column, columnIndex) => (
                <td key={`${rowIndex}-${columnIndex}`} className='px-6 py-4'>
                  {column.element(row)}
                </td>
              ))}
            </tr>
          </>
        ))}
      </tbody>
    </table>
  );
}

type TableActionsProps = {
  id: number;
  onDelete: (id: number) => void;
  entity: string;
};

export const TableActions: React.FC<TableActionsProps> = ({
  id,
  onDelete,
  entity,
  ...props
}: TableActionsProps) => {
  const [isDelete, setIsDelete] = useState(false);

  const handleConfirm = (id: number) => {
    console.log(id);
    if (isDelete) {
      onDelete(id);
      setIsDelete(false);
    } else {
      setIsDelete(true);
    }
  };

  const handleCancel = () => setIsDelete(false);

  return (
    <div className='flex gap-2'>
      {!isDelete && (
        <Link className='' href={`/dashboard/${entity}/update/${id}`}>
          <Edit className='rounded-sm bg-yellow-500 text-white p-1 hover:bg-yellow-400 transition-all duration-150' />
        </Link>
      )}

      <button onClick={() => handleConfirm(id)} className='  '>
        {isDelete ? (
          <Check className='rounded-sm bg-green-500 text-white p-1 hover:bg-green-400 transition-all duration-150' />
        ) : (
          <Trash2 className='rounded-sm bg-red-500 text-white p-1 hover:bg-red-400 transition-all duration-150' />
        )}
      </button>

      {isDelete && (
        <button onClick={handleCancel} className=' '>
          <X className='rounded-sm bg-red-500 text-white p-1 hover:bg-red-400 transition-all duration-150' />
        </button>
      )}
    </div>
  );
};
