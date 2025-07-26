import styles from './CohortDetails.module.css';

function CohortDetails({ status }) {
  const textColor = status === 'ongoing' ? 'green' : 'blue';

  return (
    <div className={styles.box}>
      <h3 style={{ color: textColor }}>{status} Cohort</h3>
      <dl>
        <dt>Details</dt>
        <dd>This is a placeholder for cohort details.</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
